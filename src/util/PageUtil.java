package util;

/**
 * @author Mr.5227
 * @date 2019/3/26 - 11:41
 * 分页工具类，获取总页数
 */
public class PageUtil {
    private int currentPage = 1;     //当前页码
    private int pageSize = 0;       //页面容量
    private int totalCount = 0;     //查询数据的总条数
    private int totalPageCount = 0;     //总页数

    //  当前页码
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

//  页面容量
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize){
        this.pageSize = pageSize;
    }

    //  查询数据的总条数
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if(totalCount > 0){
            this.totalCount = totalCount;   //总条数
            //获取总页数
            this.setPageCount();
        }
    }

    //获取总页数
    private void setPageCount(){
        int result = this.totalCount % this.pageSize;
        if(result == 0){
            //整除的情况，总条数 / 页面容量
            this.totalPageCount = this.totalCount / this.pageSize;
        }else if(result > 0){
            //不能整除的情况，总条数 / 页面容量+1
            this.totalPageCount = this.totalCount / this.pageSize + 1;
        }else{
            //其他不正确的情况
            this.totalPageCount = 0;
        }
    }


//  总页数
    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }




}
