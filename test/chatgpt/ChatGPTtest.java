package chatgpt;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Stack;

public class ChatGPTTest {

    private Stack stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack(3);
    }

    @Test
    public void testPushAndPeek() {
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.peek());
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPopRemovesElement() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushBeyondCapacityThrows() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(stack.isFull());
        assertThrows(IllegalStateException.class, () -> stack.push(4));
    }

    @Test
    public void testPopEmptyThrows() {
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    public void testPeekEmptyThrows() {
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }

    @Test
    public void testOrderIsLIFO() {
        stack.push(5);
        stack.push(10);
        stack.push(15);
        assertEquals(15, stack.pop());
        assertEquals(10, stack.pop());
        assertEquals(5, stack.pop());
    }

    @Test
    public void testIsEmptyAndIsFull() {
        assertTrue(stack.isEmpty());
        stack.push(7);
        assertFalse(stack.isEmpty());
        stack.push(8);
        stack.push(9);
        assertTrue(stack.isFull());
    }

    @Test
    public void testSizeUpdatesCorrectly() {
        assertEquals(0, stack.size());
        stack.push(11);
        stack.push(22);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }
}
