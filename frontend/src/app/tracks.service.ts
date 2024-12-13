import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TracksService {

  constructor() { }
  standardIssue = [
    {
      name: 'CS Fundamentals',
      completed: false,
      bonus : false,
      coursesVisible: false,
      courses : [
      {name: 'Learn Python', completed: false, bonus : false },
      {name: 'Learn OOP', completed: false, bonus: false },
      {name: 'Learn FP', completed: false, bonus: false},
      {name: 'Algorithms', completed: false, bonus: false },
      {name: 'Data Structures', completed: false, bonus: false },
   ]},
    {
      name: 'Backend Development',
      completed: false,
      bonus: false,
      coursesVisible: false,
      courses : [
      {name: 'Learn Go', completed: false, bonus: false },
      {name: 'Learn HTTP Clients', completed: false, bonus: false },
      {name: 'Learn SQL', completed: false, bonus: false },
      {name: 'Learn HTTP Servers', completed: false, bonus: false },
    ] },
    {name: 'Extended Learning',
      completed: false,
      bonus: false,
      coursesVisible: false,
      courses : [
      {name: 'Advanced Algorithms', completed: false, bonus: false },
      {name: 'Learn Cryptography', completed: false, bonus: false },
      {name: 'Learn Pub/Sub', completed: false, bonus: false },
    ]},
  ];
  mildEnhancements = [
    {
      name: 'CS Fundamentals',
      completed: false,
      bonus : false,
      coursesVisible: false,
      courses : [
      {name: 'Learn Python', completed: false, bonus : false },
      {name: 'Learn OOP', completed: false, bonus: false },
      {name: 'CodeWars 35', completed: false, bonus: false },
      {name: 'Learn FP', completed: false, bonus: false},
      {name: 'Algorithms', completed: false, bonus: false },
      {name: 'Data Structures', completed: false, bonus: false },
      {name: 'Neetcode up Tries', completed: false, bonus: false },
   ]},
    {
      name: 'Backend Development',
      completed: false,
      bonus: false,
      coursesVisible: false,
      courses : [
      {name: 'Learn Go', completed: false, bonus: false },
      {name: 'Learn HTTP Clients', completed: false, bonus: false },
      {name: 'Exercism Go Easy', completed: false, bonus: false },
      {name: 'Learn SQL', completed: false, bonus: false },
      {name: 'Learn HTTP Servers', completed: false, bonus: false },
      {name: 'Exercism Go Medium', completed: false, bonus: false },
    ] },
    {name: 'Extended Learning',
      completed: false,
      bonus: false,
      coursesVisible: false,
      courses : [
      {name: 'Advanced Algorithms', completed: false, bonus: false },
      {name: 'Learn Cryptography', completed: false, bonus: false },
      {name: 'Learn Pub/Sub', completed: false, bonus: false },
      {name: 'Finish Neetcode 150', completed: false, bonus: false },
    ]},
    {name: 'Frontend Development', 
      completed: false,
      bonus: false,
      coursesVisible: false,
      courses : [
      {name: 'Boot.dev JS', completed: false, bonus: false },
      {name: 'Boot.dev JS HTTP', completed: false, bonus: false },
      {name: 'FCC Reactive Web Design', completed: false, bonus: false },
      {name: 'FCC Javascript', completed: false, bonus: false },
      ]},
  ]
  moderateEnhancements = [
    {
      name: 'CS Fundamentals',
      completed: false,
      bonus : false,
      coursesVisible: false,
      courses : [
      {name: 'Learn Python', completed: false, bonus : false },
      {name: 'CodingBat Python', completed: false, bonus: false },
      {name: 'Learn OOP', completed: false, bonus: false },
      {name: 'CodeWars 50', completed: false, bonus: false },
      {name: 'Learn FP', completed: false, bonus: false},
      {name: 'Codewars 50', completed: false, bonus: false },
      {name: 'Algorithms', completed: false, bonus: false },
      {name: 'HackerRank Problem Solving Algorithms', completed: false, bonus: false },
      {name: 'Data Structures', completed: false, bonus: false },
      {name: 'HackerRank Problem Solving Data Structures', completed: false, bonus: false },
      {name: 'Neetcode up Tries', completed: false, bonus: false },
   ]},
    {
      name: 'Backend Development',
      completed: false,
      bonus: false,
      coursesVisible: false,
      courses : [
      {name: 'Learn Go', completed: false, bonus: false },
      {name: 'CodeWars 25', completed: false, bonus: false },
      {name: 'Learn HTTP Clients', completed: false, bonus: false },
      {name: 'Exercism Go Easy', completed: false, bonus: false },
      {name: 'Learn SQL', completed: false, bonus: false },
      {name: 'Learn HTTP Servers', completed: false, bonus: false },
      {name: 'HackerRank SQL', completed: false, bonus: false },
      {name: 'Exercism Go Medium', completed: false, bonus: false },
    ] },
    {name: 'Extended Learning',
      completed: false,
      bonus: false,
      coursesVisible: false,
      courses : [
      {name: 'Advanced Algorithms', completed: false, bonus: false },
      {name: 'Learn Cryptography', completed: false, bonus: false },
      {name: 'Learn Pub/Sub', completed: false, bonus: false },
      {name: 'Finish Neetcode 150', completed: false, bonus: false },
      {name: 'Random LeetCode 100', completed: false, bonus: false },      
    ]},
    {name: 'Frontend Development', 
      completed: false,
      bonus: false,
      coursesVisible: false,
      courses : [
      {name: 'Boot.dev JS', completed: false, bonus: false },
      {name: 'Boot.dev JS HTTP', completed: false, bonus: false },
      {name: 'FCC Reactive Web Design', completed: false, bonus: false },
      {name: 'FCC JavaScript Legacy', completed: false, bonus: false },
      {name: 'FCC Javascript', completed: false, bonus: false },
      ]},
    {name: 'Learn A New Programming Language',
      completed: false,
      bonus: false,
      coursesVisible: false,
      courses : [
        {name: 'Full Exercism Track', completed: false, bonus: false },
        {name: '100 Random Leetcode', completed: false, bonus: false },
        {name: 'Learn Web Major Language', completed: false, bonus: false },
      ]},
  ]

  getStandard() {
    return this.standardIssue;
  }
  getMildEnhancements() {
    return this.mildEnhancements;
  }
  getModerateEnhancements() {
    
  }
}
