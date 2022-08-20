import {Injectable} from '@angular/core';
import {IWord} from '../model/iword';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  iWordList: IWord[] = [
    {word: 'keyboard', mean: 'bàn phím'},
    {word: 'computer', mean: 'máy tính'},
    {word: 'speaker', mean: 'loa'},
    {word: 'mouse', mean: 'chuột'},
    {word: 'printer', mean: 'máy in'},
    {word: 'monitor', mean: 'màn hình'},
    {word: 'headphone', mean: 'tai nghe'},
    {word: 'hello', mean: 'xin chào'},
  ];

  constructor() {
  }

  getAll() {
    return this.iWordList;
  }

  translate(nameSearch: string) {
    return this.iWordList.find(temp => temp.word === nameSearch);
    // console.log(this.iWordList.find(temp => temp.word === nameSearch));
  }
}
