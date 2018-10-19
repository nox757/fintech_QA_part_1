package fintechQA.gen;

public abstract class RandomEntityGenerator<E> implements EntityGenerator {

    protected final RandomUtilsGenerator rdUtils;

    public RandomEntityGenerator(RandomUtilsGenerator rdUtils) {
        this.rdUtils = rdUtils;
    }

    public abstract E generate();

}
