package net.cnki.designmode.bulider;

public class Test02 {
    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    public static class Builder {
        private int servingSize;
        private int servings;
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;

        public Builder (int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int calories) {
        	this.calories = calories;
            return this;
        }

        public Builder fat(int fat) {
        	this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium) {
        	this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(int carbohydrate) {
        	this.carbohydrate = carbohydrate;
            return this;
        }

        public Test02 builder () {
            return new Test02(this);
        }
    }

    private Test02(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
