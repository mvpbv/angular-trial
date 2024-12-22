export interface LegacyHotspot {
    sum: number
    items : analyticsLesson[]
}
export interface HotSpot {
    sum: number
    chapters: Set<string>
    courses: Set<string>
    difficultyRange: number[]
    chronRange: number[]
    items : CodeChallenge[]
}
export interface CodeChallenge {
    challenge: boolean
    Title: string
    UUID: string
    IsChallenge: boolean
    LessonIndex: number
    ChapterIndex: number
    ChapterName: string
    CourseIndex: number
    CourseName: string
    TrackIndex: number
    TrackName: string
    Difficulty: number
    Chron: number
}
export interface analyticsLesson {
    id: number
    challenge: boolean
    Title: string
    UUID: string
    IsChallenge: boolean
    LessonIndex: number
    ChapterIndex: number
    ChapterName: string
    LessonType: string
    IsLocalMachine: boolean
    CourseIndex: number
    CourseName: string
    TrackIndex: number
    TrackName: string
    Difficulty: number
    Radix: number
  }