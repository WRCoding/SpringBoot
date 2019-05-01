package com.wlj.springbootcar.bean;

import java.util.List;

/**
 * @author LB
 * @create 2019-03-30 16:57
 */
public class Page {
    //当前的页数
    private int pageNum;
    //每页所展示的数据
    private int pageSize;
    //总共有多少数据
    private int totalRecord;
    //总页数
    private int totalPage;
    //查询数据的起始位置
    private int startIndex;
    //存放查询到的数据
    private List<Book> booklist;
    //相对的头页
    private int start;
    //相对的尾页
    private int end;

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                ", totalPage=" + totalPage +
                ", startIndex=" + startIndex +
                ", booklist=" + booklist +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public Page() {
    }

    public Page(int pageNum, int pageSize, int totalRecord) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;

        if(totalRecord%pageSize == 0){
            //如果刚好能够整除，则totalPage = totalRecord/pageSize
            this.totalPage = totalRecord/pageSize;
        }else{
            //如歌不能整除，则需要多加一页显示余下的数据
            this.totalPage = (totalRecord/pageSize)+1;
        }
        this.startIndex = (pageNum-1)*pageSize;
        //初始头页
        this.start = 1;
        //初始尾页
        this.end = 5;
        if(totalPage<5){
            //如果总页数小于5页，则尾页为总页数
            this.end = this.totalPage;
        }else{
            this.start = this.pageNum-2;
            this.end = this.pageNum+2;
            if(this.start<=0){
                this.start = 1;
                this.end = 5;
            }
            else if(this.end>=totalPage){
                this.end = totalPage;
                this.start = this.end-4;
            }
        }
    }

    //下面的为get/set方法
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

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public List<Book> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book> booklist) {
        this.booklist = booklist;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
