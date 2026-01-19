package org.ghoverblog.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringKatasTest {

    @Test
    void should_concatenate_string() {
        assertEquals("HelloWord", "Hello" + "Word");
    }
}
