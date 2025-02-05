package tp1.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.logic.gameobjects.DestroyerAlien;
import tp1.logic.gameobjects.ExplosiveAlien;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.RegularAlien;
import tp1.logic.gameobjects.UCMShip;
import tp1.logic.gameobjects.Ufo;

public class GameObjectContainer {

	private List<GameObject> objects;
	private int Points;
	public GameObjectContainer() {
		objects = new ArrayList<>();
		this.Points = 0;
	}

	public void add(GameObject object) {
		objects.add(object);
	}

	public void remove(GameObject object) {
		Points += object.getKillPoints();
		objects.remove(object);
		
	}
	

	public void automaticMoves() {
		for(GameObject a: objects) {
			if(a != null) {
				a.automaticMove();
				performAttack();
			}
		}
		removeDeads();
	}

	public void computerActions() {
		
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i) != null) {
				objects.get(i).computerAction();
			}
		}
	}
	
	public void performAttack() {
		for(GameObject a: objects) {
			if(a != null) {
				for(GameObject b: objects)
					if( b!= null && a.isAlive()&& b.isAlive() && !a.equals(b)) {
						a.performAttack(b);
					}
			}
		}
	}

	public int size() {
		return objects.size();
	}

	public String toString(Position position) {
		GameObject a = this.getObjectInPosition(position);
		if(a!=null) return a.toString();
		else return "";
	}

	private GameObject getObjectInPosition(Position position) {
		
		GameObject contenido = null;
		boolean fin = false;
		int i = 0;
		while (i < this.size() && fin == false) {
			if (this.objects.get(i).isOnPosition(position)) {
					contenido = this.objects.get(i);
					fin= true;
			}
			i++;
		}

		return contenido;
	}

	public String getInfo() {
		
		Ufo ufo = new Ufo(null);
		ExplosiveAlien e = new ExplosiveAlien();
		RegularAlien a = new RegularAlien();
		DestroyerAlien d  =  new DestroyerAlien();
		UCMShip u = new UCMShip(null, null);
		String devolver = "";
	
		devolver += a.getInfo()+"\n"+d.getInfo()+"\n"+e.getInfo()+"\n"+ u.getInfo()+"\n"+ ufo.getInfo();
		return devolver;
	}

	public int points() {
		return Points;
	}

	public void removeDeads() {
		for(int i = 1;i < objects.size();i++) {
			if(objects.get(i) != null && !objects.get(i).isAlive()) {
				remove(objects.get(i));
				i--;
			}
		}
	}

	public void activePerformAttack() {
		this.performAttack();
	}

	public void attackAllTable() {
		
		for(GameObject a: objects) {
			if(a != null) {
				a.receiveDamage();
			}
		}
		
	}

	public void decreasePointsSL() {
		this.Points-=5;	
	}

	public void attackSquare_Diagonal(Position pos) {
		
		for(int k=0; k< objects.size();k++) {
			GameObject obj = objects.get(k);
			if(obj != null && pos.Square(obj)) {
				obj.receiveDamage();
			}
			/*for(int i = pos.getCol()-1; i <= pos.getCol()+1; i++) {
				for(int j = pos.getRow()-1; j <= pos.getRow()+1; j++) {
					Position p = new Position(i,j);
					if(!objects.get(k).isOnPosition(pos) && objects.get(k) != null && objects.get(k).isOnPosition(p)) {
						objects.get(k).receiveDamage();
					}
				}
			}*/
		}
		
		//en diagonal 
		/*
	    for(int k=0; k< objects.size();k++) {
	        Position objectPos = objects.get(k).getPosition();
	        if(!objects.get(k).isOnPosition(pos) && objects.get(k) != null && 
	        		Math.abs(objectPos.getCol() - pos.getCol()) == Math.abs(objectPos.getRow() - pos.getRow())
	        	    && Math.abs(objectPos.getCol() - pos.getCol()) > 1) {
	            objects.get(k).receiveDamage();
	        }
	    }*/
		
	}

	public boolean contains(GameObject obj) {
		
		return this.objects.contains(obj);
	}

	public GameObject getObject(int i) {
		
		return objects.get(i);
	}
	
}
