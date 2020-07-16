package br.com.dbrainlab.infrastructure.persistence.exception;

public class NoSuchInstanceException extends RuntimeException {

    public NoSuchInstanceException(Long id) {
        super("There's no instance of ID [" + id + "] in the repository.");
    }

}
