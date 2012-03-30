package com.gordondickens.javaseven;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * User: gordondickens
 * Date: 3/30/12
 * Time: 2:34 PM
 * <p/>
 * Java 7 Switch Case on Strings and ENUMS
 */
public class SwitchOnString {
    private static final Logger logger = LoggerFactory.getLogger(SwitchOnString.class);

    @Test
    public void switchCaseTests() {
        Benefit benefit = new Benefit();
        String benefitType = benefit.getBenefitType();

        switch (benefitType) {
            case "vacation":
                logger.debug("YEAH - Vacation!");
                break;
            case "stock":
                logger.debug("Nice, hope we go public!");
                break;
            case "smoke breaks":
                logger.debug("Um, will I be docked for this?");
                break;
            default:
                logger.debug("JACKPOT!   **hic**");
                break;
        }
    }


    @Test
    public void switchOnEnumTests() {
        logger.debug("Got your Ace right here - {}", JibblyGoop.ACE);
        Random random = new Random();
        int i = random.nextInt(JibblyGoop.values().length) - 1;
        JibblyGoop[] chuck = JibblyGoop.values();

        String goop = chuck[i].toString();
        logger.debug("Checking value of {}", goop);
        switch (goop) {
            case "ACE":
            case "KING":
            case "QUEEN":
            case "JACK":
                logger.debug("Not Crap '{}'", goop);
                break;
            default:
                logger.debug("its CRAP");
        }
    }

    class Benefit {
        String getBenefitType() {
            String[] statii = {"vacation", "stock", "smoke breaks", "free beer"};

            Random random = new Random();
            Integer randomNum = random.nextInt(statii.length);
            return statii[randomNum];

        }
    }

    enum JibblyGoop {
        DEUCE, THREE, FOUR, FIVE, SIX,
        SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }
}
