package test;

import java.util.concurrent.ThreadLocalRandom;

public interface RandomBasic {

    default int aRandomInteger( ) {
        return ThreadLocalRandom.current().nextInt();
    }
}
