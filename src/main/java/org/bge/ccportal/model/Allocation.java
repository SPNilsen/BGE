package org.bge.ccportal.model;

public class Allocation {

    private String product;
    private boolean force_open;
    private boolean force_close;
    private boolean meeting;
    private int overflow;
    private String product_name;

    public Allocation() {
    }

    public Allocation(String product, String product_name, boolean force_open, boolean force_close, boolean meeting, int overflow) {
        this.product = product;
        this.product_name = product_name;
        this.force_open = force_open;
        this.force_close = force_close;
        this.meeting = meeting;
        this.overflow = overflow;
    }

    /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * @return the force_open
     */
    public boolean getForce_open() {
        return force_open;
    }

    /**
     * @param forced_open the force_open to set
     */
    public void setForce_open(boolean forced_open) {
        this.force_open = forced_open;
    }

    /**
     * @return the force_close
     */
    public boolean getForce_close() {
        return force_close;
    }

    /**
     * @param force_close the force_close to set
     */
    public void setForce_close(boolean force_close) {
        this.force_close = force_close;
    }

    /**
     * @return the meeting
     */
    public boolean getMeeting() {
        return meeting;
    }

    /**
     * @param meeting the meeting to set
     */
    public void setMeeting(boolean meeting) {
        this.meeting = meeting;
    }

    /**
     * @return the overflow
     */
    public int getOverflow() {
        return overflow;
    }

    /**
     * @param overflow the overflow to set
     */
    public void setOverflow(int overflow) {
        this.overflow = overflow;
    }

    /**
     * @return the product_name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * @param product_name the product_name to set
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product: ")
                .append(this.product)
                .append(", Product Name: ")
                .append(this.product_name)
                .append(", Force Open: ")
                .append(this.force_open)
                .append(", Force Closed: ")
                .append(this.force_close)
                .append(", Meeting: ")
                .append(this.meeting)
                .append(", Overflow: ")
                .append(this.overflow);
        return sb.toString();
    }
}
