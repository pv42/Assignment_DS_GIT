package assingmentDS.tier;

/**
 * Created by pv42 on 24.04.2017.
 */
public final class Kugelfisch extends Wassertier {
    public Kugelfisch(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Kugelfisch{" +
                "name=" + getName() +", " +
                "personal=" + getPersonal() +
                "}";
    }
}
