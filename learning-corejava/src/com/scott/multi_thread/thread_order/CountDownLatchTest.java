package com.scott.multi_thread.thread_order;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(2);

		new Thread() {
			public void run() {
				try {
					System.out.println("���߳�" + Thread.currentThread().getName() + "����ִ��");
					Thread.sleep(3000);
					System.out.println("���߳�" + Thread.currentThread().getName() + "ִ�����");
					latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();

		new Thread() {
			public void run() {
				try {
					System.out.println("���߳�" + Thread.currentThread().getName() + "����ִ��");
					Thread.sleep(3000);
					System.out.println("���߳�" + Thread.currentThread().getName() + "ִ�����");
					latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();

		try {
			System.out.println("�ȴ�2�����߳�ִ�����...");
			latch.await();
			System.out.println("2�����߳��Ѿ�ִ�����");
			System.out.println("����ִ�����߳�");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}