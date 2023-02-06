package com.scnuai.glab.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class EquipmentTest {

    private Equipment equipmentUnderTest;

    @BeforeEach
    void setUp() {
        equipmentUnderTest = new Equipment(0, "name", 0, Date.valueOf(LocalDate.of(2020, 1, 1)),
                Date.valueOf(LocalDate.of(2020, 1, 1)), 0.0, 0, 0);
    }

    @Test
    void testEquals() {
        assertThat(equipmentUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(equipmentUnderTest.canEqual("other")).isFalse();
    }

/*    @Test
    void testHashCode() {
        assertThat(equipmentUnderTest.hashCode()).isEqualTo(0);
    }*/

/*    @Test
    void testToString() {
        assertThat(equipmentUnderTest.toString()).isEqualTo("result");
    }*/
}
