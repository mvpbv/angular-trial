export interface Domain {
    id: number;
    domain: string;
    count: number;
    courseInfos: CourseInfo[];
}
export interface Link {
    id: number;
    url: string;
}
export interface CourseInfo {
    courseIndex: number;
    courseTitle: string;
}
