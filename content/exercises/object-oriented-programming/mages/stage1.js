class Unit {
    constructor(name, posX, posY) {
        this.name = name;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }
    in_area(x1, y1, x2, y2) {
        return this.pos_x >= x1 && this.pos_x <= x2 && this.pos_y >= y1 && this.pos_y <= y2;
    }
}
class Mage extends Unit {
    constructor(name, posX, posY, rangeX, rangeY) {
        super(name, posX, posY);
        this.range_x = rangeX;
        this.range_y = rangeY;
    }
    cast(x, y, units) {
        //insert here  
    }
}

