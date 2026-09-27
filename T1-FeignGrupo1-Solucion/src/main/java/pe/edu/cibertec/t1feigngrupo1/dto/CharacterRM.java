package pe.edu.cibertec.t1feigngrupo1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterRM {

    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    private Location location;
    private String image;
    private String url;
    private OffsetDateTime created;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ApiResponse {
        private Info info;
        private List<CharacterRM> results;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Info {
        private Integer count;
        private Integer pages;
        private String next;
        private String prev;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Origin {
        private String name;
        private String url;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Location {
        private String name;
        private String url;
    }
}
