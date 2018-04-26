package com.lanxu.pojo;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年04月09 23:42
 **/
public class Point {
  public float x;
  public float y;
  public Point(float x, float y){
    setLocation(x, y);
  }
  public void setLocation(float x, float y){
    this.x = x;
    this.y = y;
  }

  public float getX(){
    return x;
  }

  public float getY(){
    return y;
  }
}