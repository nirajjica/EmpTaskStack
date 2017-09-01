package com.eschool.domain;

public class Views {
    public static class Public {
    }
    public static class Email {
        public static class Public extends Views.Public {
        }
    }

    public static class Customer {
        public static class Public extends Views.Public {
            public static String[] properties = {"id", "fname", "customerId", "createdate", "accountstatus", "email", "wphone"};
        }
    }

    public static class KeywordTemplate {
        public static class Public extends Views.Public {
            public static final String[] properties = {"account", "keyword", "emailContent"};
        }
    }

}
