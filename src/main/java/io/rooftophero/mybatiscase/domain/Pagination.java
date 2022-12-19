package io.rooftophero.mybatiscase.domain;

import lombok.*;

@Getter
@Setter
@ToString
public class Pagination {

    private int totalNumber;

    //페이지 당 표시 포스트
    private int pageSize = 10;

    //화면의 페이지 수
    private int pageNumbersPerScreen;

    //현재 페이지
    private int pageNumber;

    private int totalPageNumber;

    private int pageMin;

    private int pageMax;

    private int pageStart;

    private int pageEnd;

    private int currentNumber;

    private int pagePrevious;

    private int pageNext;

    private boolean hasPrevious;

    private boolean hasNext;

    @Builder
    public Pagination(int totalNumber, int pageNumber, int pageSize) {
        this.totalNumber = totalNumber;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;

        this.pageNumbersPerScreen = 5;
        this.pageMin = 1;
        calcPagination();
    }


    private void calcPagination() {
        this.pageMax = (int)(Math.ceil(this.totalNumber /this.pageSize)) + 1;

        if(this.pageNumber <this.pageMin) this.pageNumber = this.pageMin;
        if(this.pageNumber >this.pageMax) this.pageNumber = this.pageMax;

        this.pageStart = (int)((this.pageNumber -1)/this.pageNumbersPerScreen)* pageNumbersPerScreen + 1;

        if (this.pageNumbersPerScreen < this.pageMax) {
            this.pageEnd = Math.min(this.pageStart + this.pageNumbersPerScreen - 1, this.pageMax);
        } else {
            this.pageEnd = this.pageStart + this.pageMax - 1;
        }

        this.currentNumber = (this.pageNumber - 1) * this.pageSize;

        this.pagePrevious = this.pageStart - 1;
        this.pageNext = this.pageEnd + 1;

        this.hasPrevious = this.pageStart > this.pageMin;
        this.hasNext = this.pageEnd < this.pageMax;
    }
}
