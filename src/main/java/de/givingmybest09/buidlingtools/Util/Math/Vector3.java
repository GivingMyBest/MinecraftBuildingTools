package de.givingmybest09.buidlingtools.Util.Math;

import de.givingmybest09.buidlingtools.Buidlingtools;
import net.minecraft.core.BlockPos;

public class Vector3 {

    public float x;
    public float y;
    public float z;

    public Vector3(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void normalize(){

        float x = this.x;
        float y = this.y;
        float z = this.z;

        boolean invertX = false;
        boolean invertY = false;
        boolean invertZ = false;

        if(x < 0){
            invertX = true;
            x *= -1;
        }
        if(y < 0){
            invertY = true;
            y *= -1;
        }
        if(z < 0){
            invertZ = true;
            z *= -1;
        }

        //getting the biggest Value
        float biggest = Math.max(x, Math.max(y, z));


        x = x / biggest;
        y = y / biggest;
        z = z / biggest;

        if(invertX){
            x *= -1;
        }
        if(invertY){
            y *= -1;
        }
        if(invertZ){
            z *= -1;
        }

        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static float getDistance(Vector3 a, Vector3 b){
        double deltaX = a.x - b.x;
        double deltaY = a.y - b.y;
        double deltaZ = a.z - b.z;
        double distance = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY) + (deltaZ * deltaZ));
        if(distance > 0){
            return (float)distance;
        }else{
            return (float)-distance;
        }
    }

    public static float getDistance(BlockPos a, BlockPos b){
        double deltaX = a.getX() - b.getX();
        double deltaY = a.getY() - b.getY();
        double deltaZ = a.getZ() - b.getZ();
        double distance = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY) + (deltaZ * deltaZ));
        if(distance > 0){
            return (float)distance;
        }else{
            return (float)-distance;
        }
    }
    public BlockPos toBlockPos(){
        return new BlockPos(Math.round(x), Math.round(y), Math.round(z));
    }
    public Vector3 add(Vector3 add){
        return new Vector3(this.x + add.x, this.y + add.y, this.z + add.z);
    }
}
