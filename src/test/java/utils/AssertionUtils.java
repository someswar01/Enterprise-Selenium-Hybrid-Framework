package utils;

import org.testng.asserts.SoftAssert;

/**
 * Utility class for managing ThreadLocal SoftAssert instances.
 */
public final class AssertionUtils {

    private AssertionUtils() {
        throw new UnsupportedOperationException(
                "AssertionUtils is a utility class and cannot be instantiated.");
    }

    private static final ThreadLocal<SoftAssert> SOFT_ASSERT =
            ThreadLocal.withInitial(SoftAssert::new);

    /**
     * Returns the current thread's SoftAssert.
     */
    public static SoftAssert getSoftAssert() {
        return SOFT_ASSERT.get();
    }

    /**
     * Validates all assertions.
     */
    public static void assertAll() {
        SOFT_ASSERT.get().assertAll();
    }

    /**
     * Clears ThreadLocal to prevent memory leaks.
     */
    public static void unload() {
        SOFT_ASSERT.remove();
    }
}