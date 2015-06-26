import models.World;
import play.Application;
import play.GlobalSettings;
import play.db.jpa.JPA;

import java.util.concurrent.ThreadLocalRandom;

public class Global extends GlobalSettings {

    @Override
    public void onStart(final Application application) {
        try {

            World world = new World();
            world.id = 1L;
            world.randomNumber = (long) (ThreadLocalRandom.current().nextInt(10000) + 1);
            JPA.withTransaction("default", false, () -> JPA.em().merge(world));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
