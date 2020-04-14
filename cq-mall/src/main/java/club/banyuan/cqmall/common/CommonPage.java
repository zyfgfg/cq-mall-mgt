package club.banyuan.cqmall.common;

import java.util.List;

public class CommonPage<T> {

    /**
     * pageNum : 1
     * pageSize : 10
     * totalPage : 1
     * total : 4
     * list : [{"id":1,"username":"test","password":"$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG","icon":"http://minio.banyuan.club/dev/preset/timg.jpg","email":"test@qq.com","nickName":"测试账号","note":null,"createTime":"2018-09-29T05:55:30.000+0000","loginTime":"2018-09-29T05:55:39.000+0000","status":1}]
     */

    private int pageNum;
    private int pageSize;
    private int totalPage;
    private long total;
    private List<T> list;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "CommonPage{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
