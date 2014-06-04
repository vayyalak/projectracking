package com.gridpoint.energy.domainmodel;

public class ReportValidator {

    public enum Operator {
        lt, eq, le, gt, ge
    }

    private String left;

    private String right;

    private Operator operator;

    public ReportValidator() {
    }

    public ReportValidator(ReportSetting left, ReportSetting right, Operator operator) {
        this.left = left.getName();
        this.right = right.getName();
        this.operator = operator;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( left == null ) ? 0 : left.hashCode() );
        result = prime * result + ( ( operator == null ) ? 0 : operator.hashCode() );
        result = prime * result + ( ( right == null ) ? 0 : right.hashCode() );
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ReportValidator other = (ReportValidator) obj;
        if (left == null) {
            if (other.left != null) return false;
        } else if (!left.equals(other.left)) return false;
        if (operator == null) {
            if (other.operator != null) return false;
        } else if (!operator.equals(other.operator)) return false;
        if (right == null) {
            if (other.right != null) return false;
        } else if (!right.equals(other.right)) return false;
        return true;
    }

}
