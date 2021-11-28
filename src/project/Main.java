package project;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;


import edu.princeton.cs.introcs.StdDraw;

public class Main {


	public static void drawBubble(double x, double y, double size) {
		// Note the Pen color uses a "new color" with 4 parameters
		// TODO: You are welcome to change the color & transparency of clouds
		//                             red   green   blue   transparency (0-255)
		Random r = new Random();       // 255 for white clouds. Lower numbers for grayer clouds
		// 0-255; Higher numbers are "less transparent"
		StdDraw.setPenColor(new Color(r.nextInt(128), r.nextInt(128), r.nextInt(128),   200));
		StdDraw.filledCircle(x, y, .02);
	}

	// TODO:  Complete createRandomCloudLocations(int n), which will return an array that 
	//        represents the locations of n randomly located / randomly sized clouds. 
	//            There should be n rows in the array
	//            There should be 3 columns:  
	//                  The first column should be a x coordinate of a cloud
	//                  The second column should be a y coordinate of a cloud
	//                  The third column should be the size of the cloud
	public static double [][] createRandomBubbleLocations(int n) {

		double bubble [][] = new double [n][3];
		for(int i = 0; i < n; i++) {
			double xrandom = Math.random();
			bubble [i][0] = xrandom;
			double yrandom = Math.random() * -1;
			bubble [i][1] = yrandom;
			double sizerandom = .2;
			bubble [i][2] = sizerandom;


		}
		return bubble;
	}

	public static void drawBubbleAt(double [] []bubbleLocations){
		for(int i = 0; i < bubbleLocations.length; i++) {
			drawBubble(bubbleLocations [i][0], bubbleLocations [i][1], bubbleLocations [i][2]);

		}
	}
	public static void advanceBubble(double [][] bubbleLocations) {
		for(int i = 0; i < bubbleLocations.length; i++) {
			bubbleLocations [i][1] = bubbleLocations [i][1] + .01;
			if(bubbleLocations[i][1] > 1) {
				bubbleLocations[i][1] = 0;

			}
		}


	}

	public static void main(String[] args) {

		StdDraw.enableDoubleBuffering();
		double[][] bubbleLocations = createRandomBubbleLocations(20);
		double px = 0.5;  // x location of the demo point
		double py = 0.05;  // y location of the demo point
		int counter = 0;
		double up = .5;
		double y = 0;
		int pointCount = 0;
		boolean hasChest = false;
		double sharkx = .4;
		double sharky = .6;
		double accel = .009;
		boolean hitObject = false;
		double count2 = 0;
		int i = 0;
		int j = 0;
		int k = 0;
		double ky = .3;
		double tempx = 0;
		double tempy = 0;
		int chestThere = 0;
		double rockx = .7;
		double rocky = 1;
		int rock = 0;
		int rock1 = 0;
		int rock2 = 0;
		int rock3 = 0;
		double rock1x = rockx + .3;
		double rock1y = rocky + .1;
		double rock2x = rockx + .6;
		double rock2y = rocky + .1;
		double rock3x = rockx + .2;
		double rock3y = rocky + .1;
		//
		// This song will play in the background allowing your other work
		//   to proceed. 
		// If annoyed, comment this out
		// If you want more, change playOnce() to playAlways()
		//
		//	BackgroundSong sbsp = new BackgroundSong("SpongeBobSquarePants.wav");
		//	sbsp.playOnce();
		StdDraw.setPenColor(Color.red);
		while (true) {

			String time = String.valueOf(counter/35);
			String point = String.valueOf(pointCount);
			Random r = new Random();

			StdDraw.clear();
			StdDraw.picture(0.5, 0.5, "images/underwater.jpg", 1.2, 1.2);

			StdDraw.setPenColor(Color.red);
			StdDraw.filledRectangle(.5, .9, .4, .1);

			StdDraw.setPenColor(Color.white);
			StdDraw.text(.3, .95, time);
			StdDraw.text(.5, .95, "seconds have passed");
			StdDraw.text(.78, .92, "Points:");
			StdDraw.text(.85, .92, point);
			drawBubbleAt(bubbleLocations);
			advanceBubble(bubbleLocations);

			StdDraw.setPenColor(Color.black);
			StdDraw.text(.5, .85, "Press a to move left, d to move right ");
			//rock
			StdDraw.setPenColor(new Color(169,169,169));
			StdDraw.filledCircle(rockx, rocky, .06);

			StdDraw.filledCircle(rock1x, rock1y, .06);
			StdDraw.filledCircle(rock2x, rock2y, .06);
			StdDraw.filledCircle(rock3x, rock3y, .06);

			StdDraw.setPenColor(Color.black);
			StdDraw.text(rockx, rocky, "boulder");
			rocky = rocky - .01;
			rock1y = rock1y - .01;
			rock2y = rock2y - .01;
			rock3y = rock3y - .01;

			if(rocky < .05) {
				rocky = .05;
			}
			if(rock2y < .05) {
				rock2y = .05;
			}
			if(rock1y < .05) {
				rock1y = .05;
			}
			if(rock3y < .05) {
				rock3y = .05;
			}
			//branch
			StdDraw.setPenColor(new Color(102, 51, 0));
			StdDraw.setPenRadius(.05);
			StdDraw.line(.1, 0, .1, .23);

			StdDraw.setPenRadius(.02);
			StdDraw.line(.1, .15, .22, .25);
			StdDraw.line(.1, .12, .22, .2);
			StdDraw.line(.1, .1, .22, .18);
			StdDraw.line(.1, .06, .22, .12);
			StdDraw.line(.1, .01, .22, .05);

			StdDraw.line(.1, .15, 0, .25);
			StdDraw.line(.1, .12, 0, .2);
			StdDraw.line(.1, .1, 0, .18);
			StdDraw.line(.1, .06, 0, .12);
			StdDraw.line(.1, .01, 0, .05);


			//treasure chest
			if(chestThere == 0) {
				StdDraw.setPenColor(new Color(102, 51, 0));
				StdDraw.filledRectangle(.2, .3, .1, .05);
				StdDraw.filledEllipse(.2, .35, .1, .05);
				StdDraw.setPenColor(new Color(255, 215, 0));
				StdDraw.filledRectangle(.2, .33, .1, .005);
			}
			//shark
			StdDraw.setPenColor(Color.gray);
			StdDraw.filledEllipse(sharkx, sharky, .2, .05);
			StdDraw.filledEllipse(sharkx + .05, sharky, .05, .1);
			StdDraw.setPenRadius(.04);
			StdDraw.line(sharkx - .2, sharky, sharkx - .25, sharky + .05);
			StdDraw.line(sharkx - .2, sharky , sharkx - .25, sharky - .05);
			StdDraw.setPenColor(Color.black);
			StdDraw.setPenRadius(.005);
			StdDraw.filledCircle(sharkx+.18, sharky+.01, .004);
			StdDraw.line(sharkx + .193, sharky - .01, sharkx + .15, sharky - .01);
			sharkx = sharkx + .002;
			if(sharkx > 1.5) {
				sharkx = -.5;
			}
			//hits the shark
			if(px > sharkx - .2 && px < sharkx + .3 && py > sharky-.05 && hitObject == false) {
				pointCount = pointCount - 2;
				count2 = counter/35;
				hitObject = true;
				tempx = sharkx;
				tempy = sharky;
				i = 1;
			}
			if(i == 1) {
				StdDraw.setPenColor(Color.gray);
				StdDraw.filledEllipse(sharkx, sharky, .2, .05);
				StdDraw.filledEllipse(sharkx + .05, sharky, .05, .1);
				StdDraw.setPenRadius(.04);
				StdDraw.line(sharkx - .2, sharky, sharkx - .25, sharky + .05);
				StdDraw.line(sharkx - .2, sharky , sharkx - .25, sharky - .05);
				StdDraw.setPenColor(Color.black);
				StdDraw.setPenRadius(.005);
				StdDraw.filledCircle(sharkx+.18, sharky+.01, .004);
				StdDraw.line(sharkx + .193, sharky - .01, sharkx + .15, sharky - .01);
				sharky = sharky + .008;
				sharkx = sharkx + .02;
			}
			//hits tree
			if(px > 0 && px < .25 && py > 0 && py < .25) {
				pointCount = pointCount - 1;
				count2 = counter/35;
				hitObject = true;
				j = 1;
			}
			if(j == 1) {
				if(py >.24) {
					py = py + .005;
					j =0;
				}
				else {
					px = px + .005;
				}

			}
			//hits rock
			if(px > rockx - .05 && px < rockx + .05 && py > rocky - .01 && py < rocky + .01) {
				pointCount = pointCount - 1;
				count2 = counter/35;
				rock = 1;

				hitObject = true;
			}
			if(rock == 1) {

				rocky += .002;
			}
			if(px > rock1x - .05 && px < rock1x + .05 && py > rock1y - .01 && py < rock1y + .01) {
				pointCount = pointCount - 1;
				count2 = counter/35;
				rock = 1;

				hitObject = true;
			}
			if(rock1 == 1) {

				rock1y += .002;
			}
			if(px > rock2x - .05 && px < rock2x + .05 && py > rock2y - .01 && py < rock2y + .01) {
				pointCount = pointCount - 1;
				count2 = counter/35;
				rock = 1;

				hitObject = true;
			}
			if(rock2 == 1) {

				rock2y += .002;
			}
			if(px > rock3x - .05 && px < rock3x + .05 && py > rock3y - .01 && py < rock3y + .01) {
				pointCount = pointCount - 1;
				count2 = counter/35;
				rock = 1;

				hitObject = true;
			}
			if(rock3 == 1) {

				rock3y += .002;
			}

			// Should we move?
			//
			if(hitObject == false) {
				py = py + .003;
				if (checkFor(KeyEvent.VK_A)) {
					px = px - accel;
				}
				if (checkFor(KeyEvent.VK_D)) {
					px = px + accel;
				}
				if (checkFor(KeyEvent.VK_W)) {
					py = py + accel;
				}
				if (checkFor(KeyEvent.VK_S)) {
					py = py - accel;
				}
			}
			if(hitObject) {
				if(count2 + 1 == counter/35) {
					j =0;
				}
				if(count2 + 2 == counter/35) {
					hitObject = false;
				}
			}


			//
			// The pirate
			//
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.filledCircle(px, py, .03);
			StdDraw.filledEllipse(px, py - .06, .02, .07);
			StdDraw.setPenRadius(.02);
			StdDraw.line(px, py - .05, px + .05, py - .04);
			StdDraw.line(px, py - .05, px - .05, py - .04);
			StdDraw.line(px, py - .1, px + .05, py - .13);
			StdDraw.line(px, py - .1, px - .05, py - .13);
			if(px >= .98) {
				px = .99;
			}
			if(px <= 0) {
				px = .01;
			}
			if(py <= 0) {
				py = .01;
			}
			//	py = py + .001;
			if(px > .1 && px < .32 && py > .3 && py < .4 && hasChest == false) {
				pointCount = pointCount + 5;
				hasChest = true;
				chestThere = 1;
				k = 1;

			}
			if(k == 1) {
				ky = ky + .005;
				StdDraw.setPenColor(new Color(255,215,0));
				StdDraw.filledCircle(.15, ky, .02);
				StdDraw.filledCircle(.19, ky, .02);
				StdDraw.filledCircle(.23, ky, .02);
				StdDraw.filledCircle(.22, ky - .02, .02);
				StdDraw.filledCircle(.25, ky-.02, .02);


			}


			StdDraw.show();  
			StdDraw.pause(10);   // 1/100 of a second
			counter++;
		}

	}

	/**
	 * Check to see if a given key is pressed at the moment.  This method does not
	 *   wait for a key to be pressed, so if nothing is pressed, it returns
	 *   false right away.
	 *   
	 * The event constants are found at:
	 *   https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
	 * @param key the integer code of the key
	 * @return true if that key is down, false otherwise
	 */
	private static boolean checkFor(int key) {
		if (StdDraw.isKeyPressed(key)) {
			return true;
		}
		else {
			return false;
		}
	}

}
