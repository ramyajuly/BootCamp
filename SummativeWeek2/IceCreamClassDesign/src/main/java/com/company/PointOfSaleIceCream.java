package com.company;

public class PointOfSaleIceCream {
        private int productId;
        private long barCode;
        private int size;
        private double amount;
        private String flavor;
        private int calories;
        private String allergenInfo;

        public PointOfSaleIceCream(int productId,long barCode,int size,double amount,String flavor,int calories,String allergenInfo ){
            this.productId = productId;
            this.barCode=barCode;
            this.size=size;
            this.amount=amount;
            this.flavor=flavor;
            this.calories=calories;
            this.allergenInfo=allergenInfo;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public long getBarCode() {
            return barCode;
        }

        public void setBarCode(long barCode) {
            this.barCode = barCode;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getFlavor() {
            return flavor;
        }

        public void setFlavor(String flavor) {
            this.flavor = flavor;
        }

        public int getCalories() {
            return calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }

        public String getAllergenInfo() {
            return allergenInfo;
        }

        public void setAllergenInfo(String allergenInfo) {
            this.allergenInfo = allergenInfo;
        }
}
