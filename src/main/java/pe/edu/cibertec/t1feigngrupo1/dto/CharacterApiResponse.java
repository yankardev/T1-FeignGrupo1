package pe.edu.cibertec.t1feigngrupo1.dto;

import java.util.List;


public class CharacterApiResponse {

    private Info info;
    private List<CharacterRM> results;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<CharacterRM> getResults() {
        return results;
    }

    public void setResults(List<CharacterRM> results) {
        this.results = results;
    }

    public static class Info {
        private Integer count;
        private Integer pages;
        private String next;
        private String prev;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getPages() {
            return pages;
        }

        public void setPages(Integer pages) {
            this.pages = pages;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public String getPrev() {
            return prev;
        }

        public void setPrev(String prev) {
            this.prev = prev;
        }
    }
}
