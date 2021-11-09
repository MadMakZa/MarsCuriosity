package makza.afonsky.marscuriosity.ui.main

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dmax.dialog.SpotsDialog
import makza.afonsky.marscuriosity.R
import makza.afonsky.marscuriosity.adapter.MyPhotoAdapter
import makza.afonsky.marscuriosity.api.Common
import makza.afonsky.marscuriosity.api.RetrofitServices
import makza.afonsky.marscuriosity.data.Photos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyPhotoAdapter
    lateinit var dialog: AlertDialog
    private lateinit var photosRecyclerView: RecyclerView

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.camera_fragment, container, false)

        mService = Common.retrofitService

        layoutManager = LinearLayoutManager(activity)
        photosRecyclerView = view.findViewById(R.id.photosRecyclerView)
        photosRecyclerView.setHasFixedSize(true)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        photosRecyclerView.layoutManager = layoutManager


        dialog = SpotsDialog.Builder().setCancelable(true).setContext(requireContext()).build()
        getAllPhotosList()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun getAllPhotosList() {
        dialog.show()
        mService.getPhotoList().enqueue(object : Callback<MutableList<Photos>> {
            override fun onFailure(call: Call<MutableList<Photos>>, t: Throwable) {

            }

            override fun onResponse(call: Call<MutableList<Photos>>, response: Response<MutableList<Photos>>) {
                adapter = MyPhotoAdapter(requireContext(), response.body() as MutableList<Photos>)
                adapter.notifyDataSetChanged()
                photosRecyclerView.adapter = adapter

                dialog.dismiss()
            }
        })
    }

}