package com.example.administrator.ingredion4;

/**
 * Created by Administrator on 4/13/2018.
 */


public class ingredient {

        private String ing_id;
        private String ing_name;

        //Constructors
        public ingredient() {
        }

        public ingredient(String id, String name) {
            this.ing_id = id;
            this.ing_name = name;
        }

        public ingredient(String name) {
            this.ing_name = name;
        }

        //setters

        public void setIng_id(String id) {
            this.ing_id = id;
        }

        public void setIng_name(String id) {
            this.ing_name = id;
        }

        //getters

        public String getIng_id() {
            return this.ing_id;
        }

        public String getIng_name() {
            return this.ing_name;
        }


    }

