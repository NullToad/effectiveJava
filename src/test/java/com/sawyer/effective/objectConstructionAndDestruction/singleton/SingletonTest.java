package com.sawyer.effective.objectConstructionAndDestruction.singleton;

import com.sawyer.effective.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author: Sawyer
 * @Description:
 * @Date: Created in 5:06 PM 2019/2/2
 */

public class SingletonTest extends BaseTest {

    @Test
    public void testEnumSingleton() {
        Assert.assertEquals("Sawyer", Sawyer.INSTANCE.getName());
        Sawyer.INSTANCE.setGame("OW");
        Assert.assertEquals("OW", Sawyer.INSTANCE.getGame());
        Sawyer sawyer1 = Sawyer.INSTANCE;
        Sawyer sawyer2 = Sawyer.INSTANCE;
        Assert.assertEquals(sawyer1, sawyer2);
    }

    @Test
    public void testNormalWay() {
        Lancelot lancelot1 = Lancelot.getInstance();
        Lancelot lancelot2 = Lancelot.getInstance();
        Assert.assertEquals(lancelot1, lancelot2);
        lancelot1.setAge(10);
        Assert.assertEquals(10, lancelot2.getAge());
    }

    @Test
    public void testSerializable() throws Exception {
        Lancelot lancelot1 = Lancelot.getInstance();
        lancelot1.setAge(10);

        FileOutputStream fos = new FileOutputStream("knight.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(lancelot1);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("knight.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Lancelot lancelot2 = (Lancelot) ois.readObject();
        Assert.assertEquals(lancelot1, lancelot2);
        Assert.assertEquals(10, lancelot2.getAge());
    }
}