package pe.edu.cibertec.t1feigngrupo1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String image;
    private List<String> episode;
    private String url;
    private String created;


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

}