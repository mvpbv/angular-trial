import { RankTitle } from "../rank.enum";

export interface Rank {
    name: RankTitle;
    level: number;
    xp: number;
  }