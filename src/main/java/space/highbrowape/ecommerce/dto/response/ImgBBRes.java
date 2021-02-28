package space.highbrowape.ecommerce.dto;

import lombok.Data;

@Data
public class ImgBBRes {
    private Detail data;

    private boolean success;

    private String status;

    @Data
    public class Detail {
        private String display_url;

        private String delete_url;

        private Thumb thumb;

//        private String size;
//
//        private String expiration;
//
//        private String id;
//
//        private String time;
//
//        private String title;
//
//        private String url_viewer;
//
//        private String url;

        @Data
        public class Thumb{
            private String url;
        }

    }
}

