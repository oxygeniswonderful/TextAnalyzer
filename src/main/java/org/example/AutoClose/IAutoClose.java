package org.example.AutoClose;

public interface IAutoClose extends AutoCloseable {
    @Override
    void close() throws AutoCloseException;
}
