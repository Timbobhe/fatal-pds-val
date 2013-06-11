package com.esiag.isidis.gestionMessage;

import java.util.LinkedList;

import com.esiag.jaxb.MessageFormater;

public class InfoMessageBuffer extends LinkedList<MessageFormater>{

	private String name;
	

	
	public InfoMessageBuffer(String name){
		this.name=name;
	}
	public void addBefore(MessageFormater obj){
		if(!this.contains(obj))
		this.addFirst(obj);
		
	}
	
	public void addAfter(MessageFormater obj){
		if(!contains(obj))
			addLast(obj);		
	}
	
	public void addMessage(MessageFormater obj){
		if(!contains(obj))
			this.add(obj);
		
	}
	 public void addAt(MessageFormater obj,int index){
			if(!contains(obj))
				this.add(index,obj);
	 }
	 
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void removeBefore(){
		 if(!this.isEmpty())
			 removeFirst();
	 }
	 public void removeAfter(){
		 if(!this.isEmpty())
			 removeLast();
	 }
	 public void removeMessage(MessageFormater obj){
		 if(!this.isEmpty())
			 remove(obj);
	 }
	 public void removeAt(int index){
		 if(!this.isEmpty())
			 remove(index);
	 }

}
