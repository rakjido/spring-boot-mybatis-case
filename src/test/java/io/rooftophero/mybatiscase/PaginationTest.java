package io.rooftophero.mybatiscase;

import io.rooftophero.mybatiscase.domain.Pagination;
import org.junit.jupiter.api.Test;

public class PaginationTest {
    @Test
    public void PaginationTest() throws Exception {
        // Given
        Pagination pagination = Pagination.builder()
                                            .totalNumber(186)
                                            .pageNumber(9)
                                            .pageSize(10)
                                            .build();
        // When
        System.out.println("pagination.getPageMax() = " + pagination.getPageMax());
        System.out.println("pagination.getPageMin() = " + pagination.getPageMin());
        // Then
        System.out.println("pagination.isHasPrevious() = " + pagination.isHasPrevious());
        System.out.println("pagination.isHasNext() = " + pagination.isHasNext());

        System.out.println("pagination.getPageNumber() = " + pagination.getPageNumbersPerScreen());
        System.out.println("pagination.getCurrentPage() = " + pagination.getPageNumber());
        System.out.println("pagination.getPageStart() = " + pagination.getPageStart());
        System.out.println("pagination.getPageEnd() = " + pagination.getPageEnd());
    }

}
