package com.Runnable;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Created by tanzhiwei on 18/3/22.
 *
 * 在这个线程的例子里,因为添加了同步锁,
 * 才得以保证买票的事情在三个线程里有序执行者。
 * 这一点希望用心体会。
 *
 *
 */
public class SellTicket implements Runnable{

	// 定义票数
    private Integer tickets;

    // 定义锁对象
    private Lock lock = new ReentrantLock();
    
  //若为false则售票停止
    private boolean flag=true;
    
    public SellTicket(int tickets){
        this.tickets=tickets;
    }
	@Override
	public void run() {
		while (flag) {
			ticket();
		}
	}

	private synchronized void ticket(){
		if(tickets<=0){
		     flag=false;
		     return;
		 }
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//输出当前窗口号以及出票序列号
	     System.out.println(Thread.currentThread().getName()+"售出票序列号："+tickets--);
	}
	
	 public static void main(String[] args) {
	        // 创建资源对象
	        SellTicket st = new SellTicket(100);

	        // 创建三个窗口
	        Thread t1 = new Thread(st,"win1");
	        Thread t2 = new Thread(st,"win2");
	        Thread t3 = new Thread(st,"win3");

	        // 启动线程
	        t1.start();
	        t2.start();
	        t3.start();

	    }
}
