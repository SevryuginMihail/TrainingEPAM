package Sevryugin.structural.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс описываеет попытку с помощью адаптера поместитить квадратный колышек в круглую лунку
 */
public class MainAdapter {
    private static final Logger log = LoggerFactory.getLogger(MainAdapter.class);

    public static void main(String[] args) {
        log.info("");
        RoundHole hole = new RoundHole(5);
        log.info("hole - круглая лунка радиуса "+hole.getRadius());
        RoundPeg rpeg = new RoundPeg(5);
        log.info("rpeg - круглый колышек радиуса "+rpeg.getRadius());
        log.info("влезет ли rpeg в hole? "+ hole.fits(rpeg));
        SquarePeg small_sqpeg = new SquarePeg(3);
        log.info("small_speg - квадратный колышек со стороной "+small_sqpeg.getWidth());
        SquarePegAdapter small_sqpeg_adapter = new SquarePegAdapter(small_sqpeg);
        log.info("small_sqpeg_adapter - адаптер для квадратного колышка радиуса "+small_sqpeg_adapter.getRadius());
        log.info("влезет ли small_speg в hole? "+ hole.fits(small_sqpeg_adapter));
    }
}
