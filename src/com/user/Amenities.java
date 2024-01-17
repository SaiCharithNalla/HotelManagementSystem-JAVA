package com.user;

import java.util.Scanner;

public class Amenities {
	
		public int NumberOfDays;
		public int Spa;
		public int Bar;
		public int Disco;
		public int Golf;
		public int Trek;
		public float SpaCost;
		public float BarCost;
		public float DiscoCost;
		public float GolfCost;
		public float TrekCost;
		public Amenities() {
			
			this.SpaCost = 100.0f;
			this.BarCost = 250.0f;
			this.DiscoCost = 300f;
			this.GolfCost = 350f;
			this.TrekCost = 750f;

		}
		public int getNumberOfDays() {
			return NumberOfDays;
		}
		public void setNumberOfDays(int numberOfDays) {
			NumberOfDays = numberOfDays;
		}
		public int isSpa() {
			return Spa;
		}
		public void setSpa(int spa) {
			Spa = spa;
		}
		public int isBar() {
			return Bar;
		}
		public void setBar(int bar) {
			Bar = bar;
		}
		public int isDisco() {
			return Disco;
		}
		public void setDisco(int disco) {
			Disco = disco;
		}
		public int isGolf() {
			return Golf;
		}
		public void setGolf(int golf) {
			Golf = golf;
		}
		public int isTrek() {
			return Trek;
		}
		public void setTrek(int trek) {
			Trek = trek;
		}
		public float getSpaCost() {
			return SpaCost;
		}
		public void setSpaCost(float spaCost) {
			SpaCost = spaCost;
		}
		public float getBarCost() {
			return BarCost;
		}
		public void setBarCost(float barCost) {
			BarCost = barCost;
		}
		public float getDiscoCost() {
			return DiscoCost;
		}
		public void setDiscoCost(float discoCost) {
			DiscoCost = discoCost;
		}
		public float getGolfCost() {
			return GolfCost;
		}
		public void setGolfCost(float golfCost) {
			GolfCost = golfCost;
		}
		public float getTrekCost() {
			return TrekCost;
		}
		public void setTrekCost(float trekCost) {
			TrekCost = trekCost;
		}
		public void getInformation() {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter requirements:");
			System.out.println("If facility is required press 1:");
			System.out.print("Spa:");
			this.Spa = scan.nextInt();
			System.out.print("Bar:");
			this.Bar = scan.nextInt();
			System.out.print("Disco:");
			this.Disco = scan.nextInt();
			System.out.print("Golf:");
			this.Golf = scan.nextInt();
			System.out.print("Trek:");
			this.Trek = scan.nextInt();
			
		}
		public void AlterRate() {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter respective rates:");
			System.out.print("Spa:");
			this.SpaCost = scan.nextFloat();
			System.out.print("Bar:");
			this.BarCost = scan.nextFloat();
			System.out.print("Disco:");
			this.DiscoCost = scan.nextFloat();
			System.out.print("Golf:");
			this.GolfCost = scan.nextFloat();
			System.out.print("Trek:");
			this.TrekCost = scan.nextFloat();
			scan.close();
		}
		public float calculateBill() {
			float sum = 0f;
			if (Spa==1) sum += SpaCost;
			if (Bar==1) sum += BarCost;
			if (Disco==1) sum += DiscoCost;
			if (Golf==1) sum += GolfCost;
			if (Trek==1) sum += TrekCost;
			sum *= NumberOfDays;
			return sum;
		}
		public float calculateBill(int num) {
			float sum = 0f;
			if (Spa==1) sum += SpaCost;
			if (Bar==1) sum += BarCost;
			if (Disco==1) sum += DiscoCost;
			if (Golf==1) sum += GolfCost;
			if (Trek==1) sum += TrekCost;
			sum *= num;
			return sum;
		}
	}

