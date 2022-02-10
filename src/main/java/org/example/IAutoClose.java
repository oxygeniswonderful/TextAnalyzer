package org.example;

import java.io.IOException;

public interface IAutoClose extends AutoCloseable {
    @Override
    void close() throws IOException, AutoCloseException;
}
