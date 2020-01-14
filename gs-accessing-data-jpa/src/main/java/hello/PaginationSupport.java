package hello;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public final class PaginationSupport {

	private PaginationSupport() {
	}

	public static Pageable createPageable(int offset, int limit) {
		return new LimitOffsetPageable(offset, limit);
	}

	public static Pageable createPageable(Paging paging) {
		if (paging == null) {
			throw new IllegalArgumentException("Paging object is null. Cannot proceed");
		}
		return new LimitOffsetPageable(paging.getOffset(), paging.getLimit());
	}

	public static Pageable createPageable(int offset, int limit, Sort sort) {
		return new LimitOffsetPageable(offset, limit, sort);
	}

	public static Pageable createPageable(Paging paging, Sort sort) {
		return createPageable(paging.getOffset(), paging.getLimit(), sort);
	}

	public static Pageable firstRecord() {
		return createPageable(0, 1);
	}

	public static Pageable allRecords() {
		return createPageable(0, Integer.MAX_VALUE);
	}

	public static Pageable firstRecordOrderBy(String... sortFields) {
		return createPageable(0, 1, new Sort(sortFields));
	}

	public static Pageable firstRecordOrderByDesc(String... sortFields) {
		return createPageable(0, 1, new Sort(Sort.Direction.DESC, sortFields));
	}

	public static Integer getOffsetOrDefault(Integer offset) {
		return offset == null ? 0 : offset;
	}

	public static Integer getLimitOrDefault(Integer limit) {
		return limit == null ? Integer.MAX_VALUE : limit;
	}

	private static class LimitOffsetPageable implements Pageable {
		private final int offset;
		private final int limit;
		private final Sort sort;

		LimitOffsetPageable(int offset, int limit) {
			this(offset, limit, null);
		}

		LimitOffsetPageable(int offset, int limit, Sort sort) {
			this.offset = offset;
			this.limit = limit;
			this.sort = sort;
		}

		@Override
		public int getPageNumber() {
			return 0;
		}

		@Override
		public int getPageSize() {
			return limit;
		}

		@Override
		public long getOffset() {
			return offset;
		}

		@Override
		public Sort getSort() {
			return sort;
		}

		@Override
		public Pageable next() {
			return null;
		}

		@Override
		public Pageable previousOrFirst() {
			return first();
		}

		@Override
		public Pageable first() {
			return this;
		}

		@Override
		public boolean hasPrevious() {
			return false;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}

			LimitOffsetPageable that = (LimitOffsetPageable) o;

			if (offset != that.offset || limit != that.limit) {
				return false;
			} else {
				return this.sort == null ? (that.sort == null) : this.sort.equals(that.sort);
			}
		}

		@Override
		public int hashCode() {
			int result = offset;
			result = 31 * result + limit;
			result = 31 * result + (this.sort == null ? 0 : this.sort.hashCode());
			return result;
		}
	}
}
