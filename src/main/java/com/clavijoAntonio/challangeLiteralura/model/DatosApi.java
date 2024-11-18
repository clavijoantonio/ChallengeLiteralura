package com.clavijoAntonio.challangeLiteralura.model;

import java.util.List;

public class DatosApi {
    private int count;
    private String next;
    private String previous;
    private List<DatosLibros> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<DatosLibros> getResults() {
        return results;
    }

    public void setResults(List<DatosLibros> results) {
        this.results = results;
    }
}
