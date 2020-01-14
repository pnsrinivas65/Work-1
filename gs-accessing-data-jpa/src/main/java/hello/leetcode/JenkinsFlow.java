/**

package hello.leetcode;
import hudson.model.*;
import hudson.AbortException;
import hudson.console.HyperlinkNote;
import java.util.concurrent.CancellationException;


public class JenkinsFlow {

	

	node= build.getBuiltOn().getNodeName()
	build_version = env['SPRINT_NUMBER'] + "." + build.number
	team_name = build.properties.environment.TEAM_NAME.toString()
	branch = build.properties.environment.BRANCH.toString()
	jenkins_home = build.properties.environment.JENKINS_HOME
	build_flow_name = build.properties.environment.JOB_NAME
	ansible_env = build.properties.environment.ENV_CONFIG
	ansible_groupid = build.properties.environment.REPOSITORY_GROUPID
	smoke_condition = build.properties.environment.smoke
	snapshot_condition = build.properties.environment.snapshot

	changes_file = jenkins_home + "/jobs/" + build_flow_name + "/builds/" + build.number.toString() + "/changelog.xml"
	def changes = new File(changes_file).text
	if (changes =~ '(100644|100755).*\\sfrontier/') {
	  	println "\n--------------\nChanges made in this build: \n\n" + changes
	}

	// Get committer e-mail
	mail_command = ["sh","-c", "egrep -io [a-zA-Z_]+@epam.com ${changes_file}|sort|uniq|tr '\n' ' '"].execute()
	String all_mails = mail_command.text
	if (all_mails == null || all_mails.empty) {
	  commiter_mail = "Kseniia_Mullomukhametova@epam.com"
	} else {
	  commiter_mail = all_mails
	}


	def build_parameters =  [  "WORKSPACE": build.workspace,
	                           "NODE": node,
	                           "BRANCH": branch,
	                           "jenkinsBuildNumber": build.number,
	                           "SNAPSHOT_VERSION": build_version,
	                           "ENV_CONFIG": ansible_env,
	                           "REPOSITORY_GROUPID": ansible_groupid,
	                           "ARTIFACT_SOURCE": "from_workspace"
	                         ]

	println "\n--------------\nNext step: build starting....."
	retry ( 2 ) {
	    build (build_parameters, "01.1_${team_name}_build")
	}

	parallel(
	  {
	    println "\n--------------\nNext step: Unit_Tests...."
	    build (build_parameters, "02.1_${team_name}_tests")
	    
	    println "\n--------------\nNext step: Integration_Tests starting....."
	    build (build_parameters, "03.1_${team_name}_integration_tests")

	    if ( Boolean.valueOf(snapshot_condition) ) {
	        println "\n--------------\nNext step: Snapshot starting....."
	        build (build_parameters, "05.1_${team_name}_snapshot")
	    } else {
	        println "\n--------------\nSkipping: Snapshot disabled in this flow"
	    }
	    
	    println "\n--------------\nNext step: Sonar starting....."
	    build (build_parameters, "04.1_${team_name}_sonar")
	  },
	  {
	    if ( Boolean.valueOf(smoke_condition) ) {
	      println "\n--------------\nNext step: Deploying to Env..."
	      build (build_parameters, "06.1_${team_name}_deploy")
	      
	      println "\n--------------\nNext step: Smoke tests..."
	      build (build_parameters, "automation_${team_name.toUpperCase()}_run_smoke")
	    } else {
	      println "\n--------------\nSkipping: Smoke tests are disabled in this flow"
	    }
	  }
	)

	
}
*/