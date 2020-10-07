package homework.object.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import page.object.BaseFunc;

public class BasketPage {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public BasketPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }
}
