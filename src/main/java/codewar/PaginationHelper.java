package codewar;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dauren Mussa
 * @since 12/13/16
 */
public class PaginationHelper<I> {

    public static void main(String[] args) {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        System.out.println(helper.pageCount());
        System.out.println(helper.itemCount());
        System.out.println(helper.pageItemCount(0));
        System.out.println(helper.pageItemCount(1));
        System.out.println(helper.pageItemCount(2));

        // pageIndex takes an item index and returns the page that it belongs on
        System.out.println(helper.pageIndex(5));
        System.out.println(helper.pageIndex(2));
        System.out.println(helper.pageIndex(20));
        System.out.println(helper.pageIndex(-10));
    }

    private final int itemCount;
    private final int pageCount;
    private final int itemsPerPage;
    private final int itemsAtLastPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.itemCount = collection != null ? collection.size() : 0;
        this.itemsPerPage = itemsPerPage;
        this.pageCount = itemCount / this.itemsPerPage + (itemCount % this.itemsPerPage == 0 ? 0 : 1);
        itemsAtLastPage = this.itemCount % this.itemsPerPage == 0 ? this.itemsPerPage : this.itemCount % this.itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return this.itemCount;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return this.pageCount;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex >= this.pageCount || pageIndex < 0)
            return -1;
        return (this.pageCount == pageIndex + 1) ? this.itemsAtLastPage : this.itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex >= this.itemCount || itemIndex < 0)
            return -1;
        return itemIndex / this.itemsPerPage;
    }
}