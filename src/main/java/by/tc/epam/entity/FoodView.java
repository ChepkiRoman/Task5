package by.tc.epam.entity;

import java.util.List;
import java.util.Objects;

public class FoodView {
    private List<Food> responseList;
    private int noOfPage;
    private int currentPage;

    public List<Food> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Food> responseList) {
        this.responseList = responseList;
    }

    public int getNoOfPage() {
        return noOfPage;
    }

    public void setNoOfPage(int noOfPage) {
        this.noOfPage = noOfPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodView)) return false;
        FoodView foodView = (FoodView) o;
        return getNoOfPage() == foodView.getNoOfPage() &&
                getCurrentPage() == foodView.getCurrentPage() &&
                Objects.equals(getResponseList(), foodView.getResponseList());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getResponseList(), getNoOfPage(), getCurrentPage());
    }

    @Override
    public String toString() {
        return "FoodView{" +
                "responseList=" + responseList +
                ", noOfPage=" + noOfPage +
                ", currentPage=" + currentPage +
                '}';
    }
}
