package Impl;

import Itf.ItfChangeTireSize;

public class ImplChangeTireSize implements ItfChangeTireSize {

    public Double changeTireSize(Double tireSize, Double changeFactor) {
	// TODO Auto-generated method stub
	return tireSize * changeFactor;
    }
}
