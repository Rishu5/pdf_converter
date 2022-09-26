package com.risu;

public class LoadingThreadclass extends Thread {
	
	Second_Panel lf;
	LoadingDialog ob;
	LoadingThreadclass(Second_Panel lf)
	{
		this.lf=lf;
	}
	
	public void run()
	{
		ob=new LoadingDialog(lf,true);
		visible();
	}
	
	void visible()
	{
		ob.setLocationRelativeTo(lf);
		ob.setVisible(true);
	}
	
	void close()
	{
		ob.setVisible(false);
	}
	
}
