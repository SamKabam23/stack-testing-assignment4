ackage chatgpt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChatGPTTest {

    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack(3);
    }

    @Test
    void testPushAndPeek() {
        stack.push(10);
        assertEquals(10, stack.peek());
        stack.push(20);
        assertEquals(20, stack.peek());
    }

    @Test
    void testPopReturnsLastElement() {
        stack.push(5);
        stack.push(15);
        int popped = stack.pop();
        assertEquals(15, popped);
        assertEquals(1, stack.size());
    }

    @Test
    void testIsEmptyAndIsFull() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(stack.isFull());
        assertFalse(stack.isEmpty());
    }

    @Test
    void testPeekDoesNotRemoveElement() {
        stack.push(99);
        int peeked = stack.peek();
        assertEquals(99, peeked);
        assertEquals(1, stack.size());
    }

    @Test
    void testPushToFullStackThrowsException() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Exception e = assertThrows(IllegalStateException.class, () -> stack.push(4));
        assertEquals("Stack is full", e.getMessage());
    }

    @Test
    void testPopFromEmptyThrowsException() {
        Exception e = assertThrows(IllegalStateException.class, () -> stack.pop());
        assertEquals("Stack is empty", e.getMessage());
    }

    @Test
    void testPeekFromEmptyThrowsException() {
        Exception e = assertThrows(IllegalStateException.class, () -> stack.peek());
        assertEquals("Stack is empty", e.getMessage());
    }
}
