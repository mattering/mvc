package model;

import java.util.Collections;
import java.util.Vector;
import java.util.*;
public class Tab2Model{
	public String fileName;
	public Vector<Float> vecX = new Vector<>();
	public Vector<Float> vecY = new Vector<>();

	Tab2Model(){

	}

	public float rangeY()
	{
		float range = (Math.abs(Collections.max(vecY))<Math.abs(Collections.min(vecY)))?

		               Math.abs(Collections.min(vecY)):Math.abs(Collections.max(vecY));
         return range+4;
	}
	public float rangeX(){
		float range = (Math.abs(Collections.max(vecX))<Math.abs(Collections.min(vecX)))?

		               Math.abs(Collections.min(vecX)):Math.abs(Collections.max(vecX));
         return range+4;

	}
}